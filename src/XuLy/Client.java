/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;


import javax.swing.JFrame;
import Database.User;
import view.ThongTinDoiThuForm;
//import view.TaoPhong;
import view.TimPhong;
import view.DanhSachBanBe;
import view.LoiMoiKetBan;
import view.ChoiVoiNguoi;
import view.ThongBaoGame;
import view.ChoiVoiMay;
import view.TrangChu;
import view.DangNhap;
import view.ThuHang;
import view.DangKy;
import view.DanhSachPhong;
import view.VaoPhong;
import view.ChoDoi;

/**
 *
 * @author vinhb
 */
public class Client {
    public enum View{
        LOGIN,
        REGISTER,
        HOMEPAGE,
        ROOMLIST,
        FRIENDLIST,
        FINDROOM,
        WAITINGROOM,
        GAMECLIENT,
        CREATEROOMPASSWORD,
        JOINROOMPASSWORD,
        COMPETITORINFO,
        RANK,
        GAMENOTICE,
        FRIENDREQUEST,
        GAMEAI,
        ROOMNAMEFRM
    }
    public static User user;
    //Danh sách giao diện
    public static DangNhap loginFrm;
    public static DangKy registerFrm;
    public static TrangChu homePageFrm;
    public static DanhSachPhong roomListFrm;
    public static DanhSachBanBe friendListFrm;
    public static TimPhong findRoomFrm;
    public static ChoDoi waitingRoomFrm;
    public static ChoiVoiNguoi gameClientFrm;
//    public static TaoPhong createRoomPasswordFrm;
//    public static JoinRoomPasswordFrm joinRoomPasswordFrm;
    public static ThongTinDoiThuForm competitorInfoFrm;
    public static ThuHang rankFrm;
    public static ThongBaoGame gameNoticeFrm;
    public static LoiMoiKetBan friendRequestFrm;
    public static ChoiVoiMay gameAIFrm;
    public static VaoPhong roomNameFrm;
    //Thiết lập socket
    public static SocketHandle socketHandle;
    
    public Client() {
    }

    public static JFrame getVisibleJFrame(){
        if(roomListFrm!=null&&roomListFrm.isVisible())
            return roomListFrm;
        if(friendListFrm!=null&&friendListFrm.isVisible()){
            return friendListFrm;
        }
//        if(createRoomPasswordFrm!=null&&createRoomPasswordFrm.isVisible()){
//            return createRoomPasswordFrm;
//        }
//        if(joinRoomPasswordFrm!=null&&joinRoomPasswordFrm.isVisible()){
//            return joinRoomPasswordFrm;
//        }
        if(rankFrm!=null&&rankFrm.isVisible()){
            return rankFrm;
        }
        return homePageFrm;
    }
    public void initView(){
        
        loginFrm = new DangNhap();
        loginFrm.setVisible(true);
        socketHandle = new SocketHandle();
        socketHandle.run();
    }
    
    public static void openView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm = new DangNhap();
                    loginFrm.setVisible(true);
                    break;
                case REGISTER:
                    registerFrm = new DangKy();
                    registerFrm.setVisible(true);
                    break;
                case HOMEPAGE:
                    homePageFrm = new TrangChu();
                    homePageFrm.setVisible(true);
                    break;
                case ROOMLIST:
                    roomListFrm = new DanhSachPhong();
                    roomListFrm.setVisible(true);
                    break;
                case FRIENDLIST:
                    friendListFrm = new DanhSachBanBe();
                    friendListFrm.setVisible(true);
                    break;
                case FINDROOM:
                    findRoomFrm = new TimPhong();
                    findRoomFrm.setVisible(true);
                    break;
                case WAITINGROOM:
                    waitingRoomFrm = new ChoDoi();
                    waitingRoomFrm.setVisible(true);
                    break;
                
//                case CREATEROOMPASSWORD:
//                    createRoomPasswordFrm = new TaoPhong();
//                    createRoomPasswordFrm.setVisible(true);
//                    break;
                case RANK:
                    rankFrm = new ThuHang();
                    rankFrm.setVisible(true);
                    break;
                case GAMEAI:
                    gameAIFrm = new ChoiVoiMay();
                    gameAIFrm.setVisible(true);
                    break;
                case ROOMNAMEFRM:
                    roomNameFrm = new VaoPhong();
                    roomNameFrm.setVisible(true);
            }
        }
    }
    public static void openView(View viewName, int arg1, String arg2){
        if(viewName != null){
            switch(viewName){
//                case JOINROOMPASSWORD:
//                    joinRoomPasswordFrm = new JoinRoomPasswordFrm(arg1, arg2);
//                    joinRoomPasswordFrm.setVisible(true);
//                    break;
                case FRIENDREQUEST:
                    friendRequestFrm = new LoiMoiKetBan(arg1, arg2);
                    friendRequestFrm.setVisible(true);
            }
        }
    }
    public static void openView(View viewName, User competitor, int room_ID, int isStart, String competitorIP){
        if(viewName != null){
            switch(viewName){
                case GAMECLIENT:
                    gameClientFrm = new ChoiVoiNguoi(competitor, room_ID, isStart, competitorIP);
                    gameClientFrm.setVisible(true);
                    break;
            }
        }
    }
    public static void openView(View viewName, User user){
        if(viewName != null){
            switch(viewName){
                case COMPETITORINFO:
                    competitorInfoFrm = new ThongTinDoiThuForm(user);
                    competitorInfoFrm.setVisible(true);
                    break;
            }
        }
    }
    public static void openView(View viewName, String arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case GAMENOTICE:
                    gameNoticeFrm = new ThongBaoGame(arg1, arg2);
                    gameNoticeFrm.setVisible(true);
                    break;
                case LOGIN:
                    loginFrm = new DangNhap(arg1, arg2);
                    loginFrm.setVisible(true);
            }
        }
    }
    public static void closeView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm.dispose();
                    break;
                case REGISTER:
                    registerFrm.dispose();
                    break;
                case HOMEPAGE:
                    homePageFrm.dispose();
                    break;
                case ROOMLIST:
                    roomListFrm.dispose();
                    break;
                case FRIENDLIST:
                    friendListFrm.stopAllThread();
                    friendListFrm.dispose();
                    break;
                case FINDROOM:
                    findRoomFrm.stopAllThread();
                    findRoomFrm.dispose();
                    break;
                case WAITINGROOM:
                    waitingRoomFrm.dispose();
                    break;
                case GAMECLIENT:
                    gameClientFrm.stopAllThread();
                    gameClientFrm.dispose();
                    break;
//                case CREATEROOMPASSWORD:
//                    createRoomPasswordFrm.dispose();
//                    break;
//                case JOINROOMPASSWORD:
//                    joinRoomPasswordFrm.dispose();
//                    break;
                case COMPETITORINFO:
                    competitorInfoFrm.dispose();
                    break;
                case RANK:
                    rankFrm.dispose();
                    break;
                case GAMENOTICE:
                    gameNoticeFrm.dispose();
                    break;
                case FRIENDREQUEST:
                    friendRequestFrm.dispose();
                    break;
                case GAMEAI:
                    gameAIFrm.dispose();
                    break;
                case ROOMNAMEFRM:
                    roomNameFrm.dispose();
                    break;
            }
            
        }
    }
    
    public static void closeAllViews(){
        if(loginFrm!=null) loginFrm.dispose();
        if(registerFrm!=null) registerFrm.dispose();
        if(homePageFrm!=null) homePageFrm.dispose();
        if(roomListFrm!=null) roomListFrm.dispose();
        if(friendListFrm!=null){
            friendListFrm.stopAllThread();
            friendListFrm.dispose();
        } 
        if(findRoomFrm!=null){
            findRoomFrm.stopAllThread();
            findRoomFrm.dispose();
        } 
        if(waitingRoomFrm!=null) waitingRoomFrm.dispose();
        if(gameClientFrm!=null){
            gameClientFrm.stopAllThread();
            gameClientFrm.dispose();
        } 
//        if(createRoomPasswordFrm!=null) createRoomPasswordFrm.dispose();
//        if(joinRoomPasswordFrm!=null) joinRoomPasswordFrm.dispose();
        if(competitorInfoFrm!=null) competitorInfoFrm.dispose();
        if(rankFrm!=null) rankFrm.dispose();
        if(gameNoticeFrm!=null) gameNoticeFrm.dispose();
        if(friendRequestFrm!=null) friendRequestFrm.dispose();
        if(gameAIFrm!=null) gameAIFrm.dispose();
        if(roomNameFrm!=null) roomNameFrm.dispose();
    }
    public static void main(String[] args) {
        new Client().initView();
    }
}
