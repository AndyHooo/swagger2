package com.hw.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.entity.Result;
import com.hw.entity.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiOperation;

@Api(value = "User������")
@Controller
@RequestMapping("/user")
public class UserController {
	    
	@ApiOperation(value = "�����û�id��ѯ�û���Ϣ", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/queryUserById", method = RequestMethod.GET, produces = "application/json")
	public Result queryUserById(
			@ApiParam(name = "userId", required = true, value = "�û�Id") 
			@RequestParam("userId") int userId, HttpServletRequest request) {
		User user = new User(userId, "haoyifen", 24);
		Result result = new Result();
		result.setCode(0);
		result.setData(user);
		result.setMessage("success");
		return result;
	}
}
