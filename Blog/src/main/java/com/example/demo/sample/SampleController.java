package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.SampleService;
import com.example.demo.domain.SampleEntity;

@Controller
public class SampleController {
	
	@Autowired
	private SampleService SampleService;
	
	@GetMapping("/sample")	//localhost:8080/sampleへのGETリクエスト。
	public String getSample() {	//メソッド名は頭にgetを付ける
		
		return "sample";	//sample.htmlを表示
	}
	
	@PostMapping("/sample")	//Postメソッドの処理
	public String postRequest(@RequestParam("text")String str,Model model) {	//sample.htmlのnameからの値を受け取る
		
		model.addAttribute("response",str);	//htmlから値を受け取れる。model.addAttribute("キー名", 値)
		
		return "sampleResponse";
	}
	
	@PostMapping("/sample/db")
	public String postDbRequest(@RequestParam("search")String str, Model model) {
		
		Long id = Long.parseLong(str);
		
		SampleEntity sampleEntity = SampleService.findByid(id);

		model.addAttribute("id", sampleEntity.getId());
		model.addAttribute("name", sampleEntity.getName());
		model.addAttribute("no", sampleEntity.getNo());
		
		return "sampleRepositoryDb";
	}
}

/* GET POST 違い
 * ブラウザからサーバー　リクエスト
 * サーバーからブラウザ　レスポンス
 * GETは目でパラメータが見える、ブックマーク出来る、取得する
 * POSTは目で見えない、ブックマーク出来ない、新しく登録する、POSTのみでも作れる(よくない)*/

