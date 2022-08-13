package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.SlipVehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "slip_vehicle")
public class SlipVehicleEntity {
  @Id
  private Integer slip_no;
  private String vehicle_name;
  private String vehicle_no;
  private String chassis_no;
  private String designated_classification;
  private String coler;
  private String coler_no;
  private String inspection_expiration_date;


  /**
   * ドメインオブジェクトへ変換
   *
   * @return ドメインオブジェクト
   */
  public SlipVehicle toDomainSlipVehicle() {
      return SlipVehicle.builder()
              .slip_no(this.slip_no)
              .vehicle_name(this.vehicle_name)
              .vehicle_no(this.vehicle_no)
              .chassis_no(this.chassis_no)
              .designated_classification(this.designated_classification)
              .coler(this.coler)
              .coler_no(this.coler_no)
              .inspection_expiration_date(this.inspection_expiration_date)
              .build();
  }


  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param slipVehicle ドメインオブジェクト
   * @return SlipVehicleEntity
   */
  public static SlipVehicleEntity build(SlipVehicle slipVehicle) {
      return SlipVehicleEntity.builder()
              .slip_no(slipVehicle.getSlip_no())
              .vehicle_name(slipVehicle.getVehicle_name())
              .vehicle_no(slipVehicle.getVehicle_no())
              .chassis_no(slipVehicle.getChassis_no())
              .designated_classification(slipVehicle.getDesignated_classification())
              .coler(slipVehicle.getColer())
              .coler_no(slipVehicle.getColer_no())
              .inspection_expiration_date(slipVehicle.getInspection_expiration_date())
              .build();
  }
}