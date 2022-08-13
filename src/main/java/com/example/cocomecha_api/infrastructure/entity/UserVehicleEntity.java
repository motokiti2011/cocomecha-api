package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.UserVehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_vehicle")
public class UserVehicleEntity {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "vehicle_name")
    private String vehicleName;
    @Column(name = "vehicle_no")
    private String vehicleNo;
    @Column(name = "chassis_no")
    private String chassisNo;
    @Column(name = "designated_classification")
    private String designatedClassification;
    private String coler;
    @Column(name = "coler_no")
    private String colerNo;
    @Column(name = "first_registration_date")
    private String firstRegistrationDate;
    @Column(name = "inspection_expiration_date")
    private String inspectionExpirationDate;

    /**
     * ドメインオブジェクトへ変換
     *
     * @return ドメインオブジェクト
     */
    public UserVehicle toDomainUserVehicle() {
        return UserVehicle.builder()
                .userId(this.userId)
                .vehicleName(this.vehicleName)
                .vehicleNo(this.vehicleNo)
                .chassisNo(this.chassisNo)
                .designatedClassification(this.designatedClassification)
                .coler(this.coler)
                .colerNo(this.colerNo)
                .firstRegistrationDate(this.firstRegistrationDate)
                .inspectionExpirationDate(this.inspectionExpirationDate)
                .build();
    }


    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param user ドメインオブジェクト
     * @return UserVehicleEntity
     */
    public static UserVehicleEntity build(UserVehicle userVehicle) {
        return UserVehicleEntity.builder()
                .userId(userVehicle.getUserId())
                .vehicleName(userVehicle.getVehicleName())
                .vehicleNo(userVehicle.getVehicleNo())
                .chassisNo(userVehicle.getChassisNo())
                .designatedClassification(userVehicle.getDesignatedClassification())
                .coler(userVehicle.getColer())
                .colerNo(userVehicle.getColerNo())
                .firstRegistrationDate(userVehicle.getFirstRegistrationDate())
                .inspectionExpirationDate(userVehicle.getInspectionExpirationDate())
                .build();
    }

}
