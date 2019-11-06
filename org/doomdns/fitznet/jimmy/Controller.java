package org.doomdns.fitznet.jimmy;

public class Controller{
    private GUI view;
    private DatabaseManager databaseModel;

    public Controller(GUI g, DatabaseManager dbm){
        view = g;
        databaseModel = dbm;
        //initView();
    }
    public void initView(){
    
    }
}