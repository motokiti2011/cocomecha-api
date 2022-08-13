package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.SlipDetail;
import com.example.cocomecha_api.domain.service.SlipDetailService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
// import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/slipdetail")
public class SlipDetailController {
    @NonNull
    @Autowired
    private final SlipDetailService slipDetailService;


    /**
     * 伝票No.をキーとして伝票情報を取得する
     * 
     * @param slipNo
     * @return 伝票情報
     */
    @GetMapping("/{slipNo}")
    @ResponseStatus(HttpStatus.OK)
    public List<SlipDetail> findById(@PathVariable("slipNo") String slipNo) {
        return this.slipDetailService.findById(slipNo);
    }


    /**
     * 伝票情報を取得しエリアで絞り込む
     * 
     * @param area
     * @return 伝票情報
     */
    @GetMapping("/sercharea/{area}")
    @ResponseStatus(HttpStatus.OK)
    public List<SlipDetail> findAllByArea(@PathVariable("area") String area) {

        System.out.println("引数" + area);
        List<SlipDetail> resultList = new ArrayList<SlipDetail>();
        // 伝票情報を取得しエリア情報で絞り込みを行う
        List<SlipDetail> slipDetail = this.slipDetailService.getSlipAll();
        slipDetail.stream()
        .filter(slip -> slip.getArea().equals(area))
        .forEach(slip -> resultList.add(slip));

        System.out.println("初期データ：" + slipDetail.size());
        System.out.println("返却件数：" + resultList.size());
        
        return resultList;
        
    }

    /**
     * 伝票情報を取得しカテゴリーで絞り込む
     * 
     * @param slipNo
     * @return 伝票情報
     */
    @GetMapping("/serchcategory/{area}/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<SlipDetail> findAllByCategory(@PathVariable("area") String area,@PathVariable("category") String category) {
        System.out.println("area:" + area);
        System.out.println("category:" + category);
        List<SlipDetail> resultList = new ArrayList<SlipDetail>();
        List<SlipDetail> slipDetail = this.slipDetailService.getSlipAll();
        // 伝票情報を取得し地域情報で絞り込みを行う
        if(!area.isBlank() && !area.equals("0")) {
            slipDetail.stream()
            .filter(slip -> slip.getCategory().equals(area))
            .forEach(slip -> resultList.add(slip));
        }
        // 伝票情報を取得しカテゴリー情報で絞り込みを行う
        if(!category.isBlank() && !category.equals("0")) {
            slipDetail.stream()
            .filter(slip -> slip.getCategory().equals(category))
            .forEach(slip -> resultList.add(slip));
        }
        // 条件なしの場合取得分すべてを返却する
        if(area.equals("0") && category.equals("0")) {
            return slipDetail;
        }

        System.out.println("初期データ：" + slipDetail.size());
        System.out.println("返却件数：" + resultList.size());
        
        return resultList;  
    }

    /**
     * 伝票情報を取得しエリアとカテゴリーで絞り込む
     * 
     * @param slipNo
     * @return 伝票情報
     */
    @GetMapping("/serchareacategory/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<SlipDetail> findAllByAreaCategory(@PathVariable("category") String category) {

        System.out.println("引数" + category);
        List<SlipDetail> resultList = new ArrayList<SlipDetail>();
        // 伝票情報を取得しエリア情報で絞り込みを行う
        List<SlipDetail> slipDetail = this.slipDetailService.getSlipAll();
        slipDetail.stream()
        .filter(slip -> slip.getCategory().equals(category))
        .forEach(slip -> resultList.add(slip));

        System.out.println("初期データ：" + slipDetail.size());
        System.out.println("返却件数：" + resultList.size());
        
        return resultList;  
    }

    /**
     * 伝票情報を登録する
     * 
     * @param slipNo
     * @return 伝票情報
     */
    @RequestMapping(value = "/slippost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // JSONマッピング用に作成したBeanクラスを指定する
    public SlipDetail postSlip(@RequestBody SlipDetail slip) {
        System.out.println(slip);
        // ObjectMapper objectMapper = new ObjectMapper();
        return this.slipDetailService.postSlip(slip);
    }

    /**
     * 伝票情報を更新する
     * 
     * @param slipNo
     * @return 伝票情報
     */
    @RequestMapping(value = "/{slipNo}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SlipDetail putSlip(@PathVariable("slipNo") String slipNo, @RequestBody SlipDetail slip) {
        // 更新対象確認
        if (this.slipDetailService.findById(slip.getSlipNo()).size() > 0) {
            slip.setSlipNo(slipNo);
            return this.slipDetailService.putSlip(slip);
        }
        return slip;
    }

    /**
     * 伝票情報を削除
     * 
     * @param slipNo
     * @return 伝票情報
     */
    @RequestMapping(value = "{slipNo}", method = RequestMethod.DELETE)
    void deleteSlip(@PathVariable("slipNo") String slipNo) {
        this.slipDetailService.deleteSlip(slipNo);
    }


    /**
     * 伝票情報取得
     * @return
     */
    @RequestMapping(value = "/slipget", method = RequestMethod.GET)
    public List<SlipDetail> getSlip() {
        System.out.println("log1");
        return this.slipDetailService.getSlipAll();
    }
}
