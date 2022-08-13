package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.SlipVehicle;
import com.example.cocomecha_api.domain.service.SlipVehicleService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

// import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/slipvehicle")
public class SlipVehicleController { 
    @NonNull
    @Autowired
    private final SlipVehicleService slipVehicleService;

    /**
     * 伝票No.をキーとして伝票情報を取得する
     * 
     * @param slip_no
     * @return 伝票情報
     */
    @GetMapping("/{slip_no}")
    @ResponseStatus(HttpStatus.OK)
    public List<SlipVehicle> findById(@PathVariable("slip_no") Integer slip_no) {
        return this.slipVehicleService.findById(slip_no);
    }

    /**
     * 伝票情報を登録する
     * 
     * @param slip_no
     * @return 伝票情報
     */
    @RequestMapping(value = "/slippost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // JSONマッピング用に作成したBeanクラスを指定する
    public SlipVehicle postUser(@RequestBody SlipVehicle slip) {
        // ObjectMapper objectMapper = new ObjectMapper();
        return this.slipVehicleService.postUser(slip);
    }

    /**
     * 伝票情報を更新する
     * 
     * @param slip_no
     * @return 伝票情報
     */
    @RequestMapping(value = "/{slip_no}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SlipVehicle putUser(@PathVariable("slip_no") Integer slip_no, @RequestBody SlipVehicle slip) {
        // 更新対象確認
        if (this.slipVehicleService.findById(slip.getSlip_no()).size() > 0) {
            slip.setSlip_no(slip_no);
            return this.slipVehicleService.putUser(slip);
        }
        return slip;
    }

    /**
     * 伝票情報を削除
     * 
     * @param slip_no
     * @return 伝票情報
     */
    @RequestMapping(value = "{slip_no}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("slip_no") Integer slip_no) {
        this.slipVehicleService.deleteUser(slip_no);
    }


    
    @RequestMapping(value = "/slipget", method = RequestMethod.GET)
    public List<SlipVehicle> getUserAll() {
        return this.slipVehicleService.getUserAll();
    }
}
