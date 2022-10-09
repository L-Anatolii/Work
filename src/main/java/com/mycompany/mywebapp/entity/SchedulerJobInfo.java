package com.mycompany.mywebapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "scheduler_job_info")
public class SchedulerJobInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long jobId;

    @Column(name ="jobName")
    private String jobName;

    @Column(name ="jobGroup")
    private String jobGroup;

    @Column(name ="jobStatus")
    private String jobStatus;

    @Column(name ="jobClass")
    private String jobClass;

    @Column(name ="cronExpression")
    private String cronExpression;

    @Column(name ="desc1")
    private String desc;

    @Column(name ="interfaceName")
    private String interfaceName;

    @Column(name ="repeatTime")
    private Long repeatTime;

    @Column(name ="cronJob")
    private Boolean cronJob;

    public SchedulerJobInfo() {
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Long getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(Long repeatTime) {
        this.repeatTime = repeatTime;
    }

    public Boolean getCronJob() {
        return cronJob;
    }

    public void setCronJob(Boolean cronJob) {
        this.cronJob = cronJob;
    }

    @Override
    public String toString() {
        return "SchedulerJobInfo{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", jobClass='" + jobClass + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", desc='" + desc + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", repeatTime=" + repeatTime +
                ", cronJob=" + cronJob +
                '}';
    }
}
