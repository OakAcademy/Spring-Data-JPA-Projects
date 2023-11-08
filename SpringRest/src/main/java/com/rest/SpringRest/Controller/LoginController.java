package com.rest.SpringRest.Controller;

import com.rest.SpringRest.Model.LoginForm;
import com.rest.SpringRest.Model.ResponseText;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody LoginForm loginform)
    {
        //Add operations
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/responsetext")
    @ResponseBody
    public ResponseText ChangeResponseText(@RequestBody LoginForm loginform)
    {
        //Operations
        ResponseText text=new ResponseText();
        text.setText("Response text was changed");
        return text;
    }
}
