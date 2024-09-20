package com.example.rest_project.controller



import com.example.rest_project.entity.AuthenticationRequest
import com.example.rest_project.entity.User
import com.example.rest_project.repository.UserMapper
import com.example.rest_project.security.AuthenticationService
import org.springframework.ui.Model
import com.example.rest_project.service.LoginService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController (
    private val authenticationService: AuthenticationService,
    private val encoder: PasswordEncoder,
    private val userMapper: UserMapper

    ){


    @GetMapping("/login")
    fun showLoginPage(model: Model): String {
        model.addAttribute("user", User())
        return "login"
    }


    @PostMapping("/loginCheck")
    fun loginCheck(user: User): String {


        try{

                val email = check(user.email)
                val password = encoder.encode(user.password)
                val authenticationRequest = AuthenticationRequest(email, password)

          authenticationService.authentication(authenticationRequest)
            println(" working ")
            return "/main"
        }
        catch(e : Exception){
            println(" not working ")
        }
        return "/login"
    }

    fun check(email: String?): String {
        if(email == null){
            return error("wrong")
        }
        else{
            return email
        }
    }
}
