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
    List<Gym> getAllAvailableGyms();
    Gym getGymById(int gymId);
    void updateGym(Gym gym);
    void removeGym(Gym gym);
    void createGym(Gym gym);
}
