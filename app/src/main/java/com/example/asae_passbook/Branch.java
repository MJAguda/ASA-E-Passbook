package com.example.asae_passbook;

public class Branch {

    // Lazy Singleton
    private static Branch intance;
    private Branch(){}
    public static Branch getInstance(){
        if(intance == null){
            intance = new Branch();
        }
        return intance;
    }

    private String branchId;
    private String branchName;
    private String adminPassword;

    // Setters
    public void setBranchId(String branchId){
        this.branchId = branchId;
    }

    public void setBranchName(String branchId){
        this.branchId = branchId;
    }

    public void setAdminPassword(String branchId){
        this.branchId = branchId;
    }

    // Getters
    public String getBranchId(){    return branchId;    }
    public String getBranchName(){    return branchName;    }
    public String getAdminPassword(){    return adminPassword;    }
}
