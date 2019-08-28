package com.example.demo.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	
	@GetMapping("/sample")	//localhost:8080/sampleへのGETリクエスト。
	public String getSample() {	//メソッド名は頭にgetを付ける
		
		return "sample";	//sample.htmlを表示
	}
}
