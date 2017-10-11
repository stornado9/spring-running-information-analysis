package com.pxue.week1.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
//import org.h2.engine.User;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "INFORMATION")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Information {

    private String runningId;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;

    @JsonIgnore
    private double latitude;
    private double longitude;
    private Date timestamp = new Date();

    @Id
    @GeneratedValue
    private Long userid;
    //private String username;
    //private String address;
    private String healthWarningLevel;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="address", column = @Column(name="address")),
            @AttributeOverride(name ="username", column = @Column(name="username"))
    })
    private UserInfo userInfo;

    public Information(){};

    public enum WarnigLevel{
        LOW, MEDIUM, HIGH, UNDEFINE;
    }
    public String getHealthWarningLevel(){
            if (this.heartRate >= 60 && this.heartRate <= 75)
                this.healthWarningLevel = WarnigLevel.LOW.toString();
            else if (this.heartRate > 75 && this.heartRate < 120)
                this.healthWarningLevel = WarnigLevel.MEDIUM.toString();
            else if (this.heartRate >= 120)
                this.healthWarningLevel = WarnigLevel.HIGH.toString();
            else
                this.healthWarningLevel = WarnigLevel.UNDEFINE.toString();
            return this.healthWarningLevel;
    }

    @JsonCreator
    public Information( @JsonProperty("hearRate") int heartRate)
    {
        if(heartRate == 0)
            this.heartRate = (int)(Math.random() * 200 + 60);
        else
            this.heartRate = heartRate;

        getHealthWarningLevel();
    }
}
