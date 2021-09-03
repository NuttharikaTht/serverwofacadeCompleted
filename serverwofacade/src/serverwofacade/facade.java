package serverwofacade;

public class facade {
    private static facade myFacade;

    private facade() {}

    public static facade getmyFacade(){
        if(myFacade == null){
            myFacade = new facade();
        }
        return myFacade;
    }

    public void serverStart() {
        ScheduleServer func = new ScheduleServer();
        func.startBooting();
        func.readSystemConfigFile();
        func.init();
        func.initializeContext();
        func.initializeListeners();
        func.createSystemObjects();
    }

    public void serverShutdown() {
        ScheduleServer func = new ScheduleServer();
        func.releaseProcesses();
        func.destory();
        func.destroySystemObjects();
        func.destoryListeners();
        func.destoryContext();
        func.shutdown();

    }


}
