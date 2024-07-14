package com.example.carbooking.helpler;

import android.content.Context;

import com.example.carbooking.Entity.Category;
import com.example.carbooking.Entity.Order;
import com.example.carbooking.Entity.Role;
import com.example.carbooking.Entity.Tour;
import com.example.carbooking.Entity.User;
import com.example.carbooking.Entity.Vehicle;
import com.example.carbooking.repository.CategoryRepository;
import com.example.carbooking.repository.OrderRepository;
import com.example.carbooking.repository.RoleRepository;
import com.example.carbooking.repository.StatusRepository;
import com.example.carbooking.repository.TourRepository;
import com.example.carbooking.repository.UserRepository;
import com.example.carbooking.repository.VehicleRepository;

import java.util.Random;

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
        if (categoryRepository.getAllCategory().isEmpty()) {
            Category domestic = new Category("Domestic");
            Category international = new Category("International");
            categoryRepository.createCategory(domestic);
            categoryRepository.createCategory(international);
        }

        if (vehicleRepository.getAllVehicle().isEmpty()) {
            Vehicle bus = new Vehicle("Bus");
            Vehicle car = new Vehicle("Car");
            Vehicle motorbike = new Vehicle("Motorbike");
            Vehicle boat = new Vehicle("Boat");
            Vehicle helicopter = new Vehicle("Helicopter");
            vehicleRepository.createVehicle(bus);
            vehicleRepository.createVehicle(car);
            vehicleRepository.createVehicle(motorbike);
            vehicleRepository.createVehicle(boat);
            vehicleRepository.createVehicle(helicopter);
        }

        if (tourRepository.getAllTour().isEmpty()) {
            for (int i = 0; i < 20; i++) {
                Tour tour = new Tour();
                tour.setTile("Tour tham quan địa đạo Củ Chi theo nhóm nhỏ");
                tour.setLocationFrom("Ha Noi");
                tour.setLocationTo("Da Nang");
                tour.setTourTime("2024-07-15");
                tour.setDateNumber(7);
                tour.setTourSchdule("2024-07-15 - 2024-07-22");
                tour.setPricePerPerson(1200000);
                tour.setContactNumber("0123456789");
                tour.setCategoryId(1);
                tour.setVehicle(1);
                tour.setDescription("Bạn sẽ có cơ hội đi thử một lối vào nhỏ ẩn trong đường hầm để hiểu cách mọi người từng di chuyển trong đó. Trong các đường hầm sẽ có các kho chứa, cửa bẫy, nhà máy sản xuất vũ khí, trung tâm chỉ huy và bệnh viện dã chiến.\n" +
                        "Bạn sẽ được nếm thử một loại thực phẩm phổ biến trong những năm tháng chiến tranh, đó là sắn. Khi trả thêm một khoản phí, bạn sẽ được bắn súng trường M16 tại một địa điểm bắn súng.");
                tour.setImage("https://r-xx.bstatic.com/xdata/images/xphoto/max1200/298835198.jpg?k=783ebd5d0bbbe95092c5e534fb0c6ca3d1816e269eb0192dc075b42728f1f098&o=");
                tour.setAvaliable(new Random().nextBoolean());
                tourRepository.createTour(tour);
            }
        }

        if(orderRepository.getAllOrder().isEmpty()){
        }
    }
}
