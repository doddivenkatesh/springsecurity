package com.springsecurity.springsecurity.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.service.AnnualEnterpriseService;

import jakarta.annotation.Resource;

@RestController
public class AnnualRestController {
	@Resource(name="annualEnterprise")
	private AnnualEnterpriseService annualEnterprise;
	
	@RequestMapping(path="feed")
	public void setDataDB() throws IOException {
		annualEnterprise.saveCustomerDate();
	}

}


//const fetchUserProfile = async (token) => {
//
//   try{
//       const response = await fetch("http://localhost:8080/profile", {
//        method:"GET",
//        headers:{
//            "Authorization": `Bearer ${token}`,
//        },
//       
//
//       }
//
//       );
//
//       if(response.ok){
//       const data = await response.json();
//       console.log(data);
//       setprofile(data);
//     
//       }else{
//        setMessage(" Failed to fetch the profile ");
// 
//       } 
//
//   
//}catch(error){
//
//    console.log("Error :" + error);
//    setMessage("an error occured please try again.");
//}
//};




 /* (<div> 
            <h3>User profile</h3>
            <p>Username :{profile.username}</p>
            <p>Roles: {profile.roles.join(", ")}</p>
            <p>message: {profile.message}</p>
                </div>)}
                {message && <p>{message}</p>}
                {jwt && <p>{jwt}</p>} */
    