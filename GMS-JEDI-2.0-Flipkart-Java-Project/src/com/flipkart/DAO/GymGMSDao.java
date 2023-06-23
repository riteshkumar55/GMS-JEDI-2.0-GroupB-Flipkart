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
    public List<Gym> getAllMyGyms(String username);
    Gym getGymById(int gymId);
    void updateGym(Gym gym);
    String removeGym(int gymId);
    void createGym(Gym gym);
}
