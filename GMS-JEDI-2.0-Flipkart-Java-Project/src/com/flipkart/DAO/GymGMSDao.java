/**
 * 
 */
package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Gym;

/**
 * 
 */
public interface GymGMSDao {
	List<Gym> getAllGyms();
    List<Gym> getAllAvailableGyms();
    List<Gym> getAllMyGyms(String username);
    Gym getGymById(int gymId);
    void updateGym(Gym gym);
    String removeGym(int gymId);
    Gym createGym(Gym gym);
    boolean updateApproval(int gymId);
}
