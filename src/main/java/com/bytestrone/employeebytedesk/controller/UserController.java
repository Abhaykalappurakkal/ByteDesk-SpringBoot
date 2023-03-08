//package com.bytestrone.employeebytedesk.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bytestrone.employeebytedesk.service.UserService;
//
//@RestController
//@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:4200")
//public class UserController {
//
//	@Autowired
//	private UserService service;
//
//	// login user
////	@SuppressWarnings("unchecked")
////	@PostMapping("/login")
////	public ResponseEntity<UserModel> loginUser(@RequestBody UserModel user) throws Exception {
////		UserModel userData = service.findLoginUser(user);
////		if(userData != null) {
////			if(userData.getIsUserLogin().booleanValue()== false) {
////				return ResponseEntity.ok(service.setIsLogin(userData));
////			}
////			else
////				return null;
////		}
////		return (ResponseEntity<UserModel>) ResponseEntity.internalServerError();
////	}
//	
////	//logout user
////	@PutMapping("/logout/{userId}")
////	public ResponseEntity<Boolean> logoutUser(@PathVariable String userId){
////		UserModel userData = service.resetIsLogin(userId);
////		System.out.println(userData.getIsUserLogin());
////		return (ResponseEntity<Boolean>) ResponseEntity.ok(userData.getIsUserLogin());
////	}
//
//}
