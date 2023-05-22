package com.example.demo.controller.customer;

import com.example.demo.config.MyConstants;
import com.example.demo.config.SendMail;
import com.example.demo.dto.CustomerForUpdateDTO;
import com.example.demo.dto.account.CustomerUpdateDTO;
import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.security.Principal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IAccountService accountService;
//    @Autowired
//    JavaMailSender javaMailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/{id}")
    public Customer findCustomerById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @GetMapping("/user/findByUsername/{username}")
    public ResponseEntity<Customer> findCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(customerService.findByUsername(username), HttpStatus.OK);
    }

    /**
     * Mô phỏng dữ liệu cứng
     * Lấy ra những vé người dùng đã chọn
     * TanHP
     * @return List<Ticket>
     */
    @GetMapping("/user/ticket-choosed")
    public ResponseEntity<List<Ticket>> findTicketsChoosed() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticketService.findById("1"));
        ticketList.add(ticketService.findById("2"));
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    /**
     * @param ticket
     * Cập nhật thông tin vé khi xác nhận đặt vé. Thay đổi trạng thái vé và thêm customer_id vào vé
     * TanHP
     */
    @PostMapping("/user/confirm-booking-ticket")
    public ResponseEntity<Void> confirmBookingTicket(@RequestBody Ticket ticket, Principal principal) {
        Customer customer = customerService.findByUsername(principal.getName());
        ticket.setStatus(1);
        ticket.setCustomer(customer);
        Date date = new Date();
        ticket.setBookDateTime(date);

        Ticket ticketCheckDB = ticketService.findTicketByIdAndStatus(ticket.getId(), 1);
        if (ticketCheckDB == null) {
            ticketService.createOrUpdate(ticket);
            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            String priceStr = numberFormat.format(ticket.getPrice());

            String subject = "A04CINEMA - THÔNG BÁO ĐẶT VÉ THÀNH CÔNG";
            String message =  "CHÚC MỪNG QUÝ KHÁCH ĐÃ ĐẶT VÉ THÀNH CÔNG !!!" +
                    "\n" +
                    "\n" +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div style=\"width: 60%; margin: auto; margin-top: 20px; border: 1px solid #333;\">\n" +
                    "        <div style=\"width: 30%;margin:auto\">\n" +
                    "            <div style=\"text-align: center;\">\n" +
                    "                <h1 style=\"color: #dd3f05!important; font-weight: bold; margin: 15px 0;\">A04CINEMA</h1>\n" +
                    "                <span style=\"color: #F26B38; font-weight: 800;\">ENJOY THE SHOW</span>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div style=\"width: 70%; text-align: center;margin:auto\">\n" +
                    "            <h3>THÔNG TIN VÉ</h3>\n" +
                    "            <table style=\"text-align: left; margin: auto;\">\n" +
                    "                <tbody>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Mã vé : </th>\n" +
                    "                        <td>"+ticket.getId()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Rạp : </th>\n" +
                    "                        <td>"+ticket.getChairRoom().getRoom().getName()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Màn hình : </th>\n" +
                    "                        <td>"+ticket.getChairRoom().getRoom().getScreen()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Suất chiếu : </th>\n" +
                    "                        <td>"+ticket.getShowTime().getStartTime()+ " | " +dt.format(ticket.getShowTime().getDate())+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Ghế : </th>\n" +
                    "                        <td>"+ticket.getChairRoom().getChair().getName()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Giá vé : </th>\n" +
                    "                        <td>"+priceStr+"</td>\n" +
                    "                    </tr>\n" +
                    "                </tbody>\n" +
                    "            </table>\n" +
                    "            <span>===============================</span>\n" +
                    "            <h3>THÔNG TIN KHÁCH HÀNG</h3>\n" +
                    "            <table style=\"text-align: left; margin: auto;\">\n" +
                    "                <tbody>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Họ tên : </th>\n" +
                    "                        <td>"+customer.getFullName()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Email : </th>\n" +
                    "                        <td>"+customer.getEmail()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">CMND : </th>\n" +
                    "                        <td>"+customer.getCardId()+"</td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <th scope=\"row\">Số điện thoại : </th>\n" +
                    "                        <td>"+customer.getPhoneNumber()+"</td>\n" +
                    "                    </tr>\n" +
                    "                </tbody>\n" +
                    "            </table>\n" +
                    "            <span>===============================</span>\n" +
                    "            <table style=\"text-align: left; margin: auto;\">\n" +
                    "                <tbody>\n" +
                    "                    <tr>\n" +
                    "                    <th scope=\"row\">TỔNG TIỀN : </th>\n" +
                    "                    <td>"+priceStr+"</td>\n" +
                    "                    </tr>\n" +
                    "                </tbody>\n" +
                    "            </table>\n" +
                    "            <span>===============================</span>\n" +
                    "            <div style=\"padding: 15px 0; color: #333; text-align: center;\">\n" +
                    "                <span>CẢM ƠN QUÝ KHÁCH VÀ HẸN GẶP LẠI</span><br>\n" +
                    "                <span>Website: http://localhost:4200/</span>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>";

            SendMail.send(customer.getEmail(), subject, message, MyConstants.MY_EMAIL, MyConstants.MY_PASSWORD);

//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(customer.getEmail());
//            message.setSubject("ĐẶT VÉ THÀNH CÔNG");
//
//            message.setText("Xác nhận đặt vé thành công !!!" +
//                    "\n================= THÔNG TIN ĐẶT VÉ =================" +
//                    "\n    Mã vé: " + ticket.getId() +
//                    "\n    Rạp: " + ticket.getChairRoom().getRoom().getName() +
//                    "\n    Màn hình : " + ticket.getChairRoom().getRoom().getScreen() +
//                    "\n    Ghế : " + ticket.getChairRoom().getChair().getName() +
//                    "\n    Giá vé : " + ticket.getPrice() +
//                    "\n=============== THÔNG TIN KHÁCH HÀNG ===============" +
//                    "\n    Họ tên : " + customer.getFullName() +
//                    "\n    Email : " + customer.getEmail() +
//                    "\n    CMND : " + customer.getCardId() +
//                    "\n    Số điện thoại : " + customer.getPhoneNumber() +
//                    "\n====================================================" +
//                    "\n    TỔNG TIỀN : " + ticket.getPrice());
////
//            javaMailSender.send(message);
        }
        else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @param page
     * @return Ticket List
     * @Method : Get all ticket by customer
     * @Author : TriLHH
     */
    @GetMapping("/user/ticket/{page}")
    public ResponseEntity<Page<Ticket>> getAllTicketByCustomer(@PathVariable int page, Principal principal) {
        Account account = accountService.findByUsername(principal.getName()).orElse(null);
        Customer customer = customerService.findCustomerByAccount(account);
        Page<Ticket> ticketList = ticketService.findAllTicketByCustomer(customer, PageRequest.of(page, 5));
        if (ticketList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/admin/customer-management")
    public ResponseEntity<Page<Customer>> getCustomerList(@RequestParam(name = "search", required = false, defaultValue = "") String search,
                                                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                          @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                                          @RequestParam(name = "sort", required = false, defaultValue = "asc") String sort) {
        /**
         * @method: show customer list, show search result, choose page
         * @author: DanhHC
         * @params: search input, page, size, sort
         * @return: customer list
         */
        System.out.println("test - list customer");
        Sort sortable = Sort.by("id").ascending();
        if (sort.equals("asc")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return new ResponseEntity<>(customerService.searchCustomerByName(search, pageable), HttpStatus.OK);
    }

    @GetMapping("/admin/update/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        /**
         * @method: get customer by id
         * @author: DanhHC
         * @params: customer id
         * @return: customer with corresponding id
         */
        System.out.println("test - id customer");
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        /**
         * @method: edit customer
         * @author: DanhHC
         * @params: customer
         * @return: void
         */
        Customer oldCustomer = customerService.findCustomerById(customer.getId());

        if (customerService.checkDuplicateEmail(customer.getEmail()) > 0 && !customer.getEmail().equals(oldCustomer.getEmail())) {
            return new ResponseEntity<>("Email đã được sử dụng, vui lòng điền email khác.", HttpStatus.BAD_REQUEST);
        }
        if (customerService.checkDuplicatePhoneNumber(customer.getPhoneNumber()) > 0
        && !customer.getPhoneNumber().equals(oldCustomer.getPhoneNumber())) {
            return new ResponseEntity<>("Số điện thoại đã được sử dụng, vui lòng điền số điện thoại khác.", HttpStatus.BAD_REQUEST);
        }
        customerService.saveCustomer(customer);
        if (!customer.getAccount().getPassword().equals("")) {
            String passInput = customer.getAccount().getPassword();
            String passEncode = passwordEncoder.encode(passInput);
            customer.getAccount().setPassword(passEncode);
            accountService.updatePassword(customer);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Author: NghiaTDD
     */
    @PutMapping("/user/edit/{id}")
    public ResponseEntity<?> updateTaiKhoan(@PathVariable String id, @RequestBody CustomerForUpdateDTO customerForUpdateDTO) {
        Optional<Customer> customerOptional = customerService.findByIdForByUpdate(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = new Customer(
                customerForUpdateDTO.getId(),
                customerForUpdateDTO.getFullName(),
                customerForUpdateDTO.getGender(),
                customerForUpdateDTO.getBirthday(),
                customerForUpdateDTO.getEmail(),
                customerForUpdateDTO.getPhoneNumber(),
                customerForUpdateDTO.getAddress(),
                customerForUpdateDTO.getCardId()
        );
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // NghiaTDD
    @PutMapping("/user/edit")
    public ResponseEntity<?> updateTaiKhoan(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
//        Optional<Customer> customerOptional = customerService.findByIdForByUpdate(customerUpdateDTO.getId());
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        Customer customer = new Customer(
                customerUpdateDTO.getId(),
                customerUpdateDTO.getFullName(),
                customerUpdateDTO.getGender(),
                customerUpdateDTO.getBirthday(),
                customerUpdateDTO.getEmail(),
                customerUpdateDTO.getPhoneNumber(),
                customerUpdateDTO.getAddress(),
                customerUpdateDTO.getCardId()
        );
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

