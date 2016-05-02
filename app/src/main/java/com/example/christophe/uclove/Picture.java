package com.example.christophe.uclove;

/*
 * Created by antoine on 02/05/16.
 */

public class Picture {
    public String I_D;
    public String File;
    public boolean Profile;

    public Picture (String I_D, String File, boolean Profile){

        this.I_D= I_D;
        this.File = File;
        this.Profile = Profile
    }
    public String getI_D(){return this.I_D;}

    public void setI_D(String newi){
        this.I_D = newi;
    }

    public String getFile(){return this.File;}

    public boolean getProfile(){return this.Profile;}

    public void setProfile (boolean pro){
        this.Profile = pro;
    }





}
