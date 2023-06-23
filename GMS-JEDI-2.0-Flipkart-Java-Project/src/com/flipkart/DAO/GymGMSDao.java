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
    Gym getGymById(int gymId);
    void updateGym(Gym gym);
    void removeGym(Gym gym);
    void createGym(Gym gym);
    void updateApproval(int gymId);
}
