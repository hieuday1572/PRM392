package com.example.carbooking.helpler;

import android.content.Context;

import com.example.carbooking.Entity.Role;
import com.example.carbooking.Entity.User;
import com.example.carbooking.repository.CategoryRepository;
import com.example.carbooking.repository.OrderRepository;
import com.example.carbooking.repository.RoleRepository;
import com.example.carbooking.repository.StatusRepository;
import com.example.carbooking.repository.TourRepository;
import com.example.carbooking.repository.UserRepository;
import com.example.carbooking.repository.VehicleRepository;

public class SeedDatabase {
    private final Context context;

    public SeedDatabase(Context context) {
        this.context = context;
    }

    public void Initialize(){
        UserRepository userRepository = new UserRepository(context);
        VehicleRepository vehicleRepository = new VehicleRepository(context);
        TourRepository tourRepository = new TourRepository(context);
        StatusRepository statusRepository = new StatusRepository(context);
        RoleRepository roleRepository = new RoleRepository(context);
        OrderRepository orderRepository = new OrderRepository(context);
        CategoryRepository categoryRepository = new CategoryRepository(context);
        if(roleRepository.getAllRole().size() == 0){
            Role user = new Role();
            user.setId(1);
            user.setRoleName(1);
            Role manager = new Role();
            manager.setId(2);
            manager.setRoleName(2);
            roleRepository.createRole(user);
            roleRepository.createRole(manager);
        }
        if(userRepository.getAllUser().size()==0){
            User user = new User();
            user.setUserName("admin");
            user.setPassword("admin");
            user.setRole_id(2);
            user.setLocked(false);
            userRepository.createUser(user);
        }
    }
}
