/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Community;

import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class CommunityDirectory {

    private ArrayList<Community> communityList;

    public CommunityDirectory() {
        communityList = new ArrayList<>();
    }

    public ArrayList<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(ArrayList<Community> communityList) {
        this.communityList = communityList;
    }

    public Community addCommunity() {
        Community community = new Community();
        communityList.add(community);
        return community;
    }

}
