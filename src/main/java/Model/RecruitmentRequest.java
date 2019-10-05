package main.java.Model;

public class RecruitmentRequest {
    private String contractType;
    private String requestingDep;
    private int experience;
    private String jobTitle;
    private String jobDescription;

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getRequestingDep() {
        return requestingDep;
    }

    public void setRequestingDep(String requestingDep) {
        this.requestingDep = requestingDep;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
