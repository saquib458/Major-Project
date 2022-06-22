package com.Ecommerce.Backend.Application.event;

import com.Ecommerce.Backend.Application.entities.*;
import com.Ecommerce.Backend.Application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    Product_variationRepo productVariationRepo;


    public void createRoles()
    {


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role1=new Role();
        Role role2 = new Role();
        Role role3 =new Role();

        role1.setId(1l);
        role1.setAuthority("ROLE_ADMIN");

        role2.setId(2l);
        role2.setAuthority("ROLE_SELLER");

        role3.setId(3l);
        role3.setAuthority("ROLE_CUSTOMER");

        roleRepo.save(role1);
        roleRepo.save(role2);
        roleRepo.save(role3);



        if(Objects.isNull(userRepo.findByEmail("saquibmohd458@gmail.com")))
        {
            Role role = roleRepo.findById(1l).get();
            Set<User> users = new HashSet<>();

            Set<Role> roles = new HashSet<>();

            User user = new User();
            user.setId(1l);
            user.setEmail("saquibmohd458@gmail.com");
            user.setFirstName("Mohd");
            user.setMiddleName("Saquib");
            user.setLastName("Ansari");
            user.setPassword(new BCryptPasswordEncoder().encode("S@quib1411"));



            users.add(user);
             role.setUsers(users);


             roles.add(role);
             user.setRoles(roles);


           user.setIs_Deleted(Boolean.FALSE);
           user.setIs_Active(Boolean.TRUE);
           user.setIs_Expired(Boolean.FALSE);
           user.setIs_Locked(Boolean.FALSE);
           user.setIs_Deleted(Boolean.FALSE);
           user.setInvalid_attempt_count(0);
           user.setPassword_update_date(new Date());

            System.out.println("hello");
            userRepo.save(user);
            users.clear();
            roles.clear();


            User seller1 = new User();
            seller1.setId(2l);
            seller1.setEmail("mo.saq9896@gmail.com");
            seller1.setFirstName("Mohd");
            seller1.setMiddleName("Saquib");
            seller1.setLastName("Ansari");
            seller1.setPassword(new BCryptPasswordEncoder().encode("S@quib1411"));

            role = roleRepo.findById(2l).get();



            users.add(seller1);
            role.setUsers(users);

            roles.add(role);
            user.setRoles(roles);


            seller1.setIs_Deleted(Boolean.FALSE);
            seller1.setIs_Active(Boolean.TRUE);
            seller1.setIs_Expired(Boolean.FALSE);
            seller1.setIs_Locked(Boolean.FALSE);
            seller1.setIs_Deleted(Boolean.FALSE);
            seller1.setInvalid_attempt_count(0);
            seller1.setPassword_update_date(new Date());

            System.out.println("hello");
            userRepo.save(seller1);
            users.clear();
            roles.clear();

            User seller2 = new User();
            seller2.setId(3l);
            seller2.setEmail("mo.saq9896+1@gmail.com");
            seller2.setFirstName("Mohd");
            seller2.setMiddleName("Saquib");
            seller2.setLastName("Ansari");
            seller2.setPassword(new BCryptPasswordEncoder().encode("S@quib1411"));

            role = roleRepo.findById(2l).get();



            users.add(seller2);
            role.setUsers(users);

            roles.add(role);
            user.setRoles(roles);


            seller2.setIs_Deleted(Boolean.FALSE);
            seller2.setIs_Active(Boolean.TRUE);
            seller2.setIs_Expired(Boolean.FALSE);
            seller2.setIs_Locked(Boolean.FALSE);
            seller2.setIs_Deleted(Boolean.FALSE);
            seller2.setInvalid_attempt_count(0);
            seller2.setPassword_update_date(new Date());

            System.out.println("hello");
            userRepo.save(seller2);
            users.clear();
            roles.clear();


            Category electronics = new Category("Electronics");
            electronics.setCategory(null);
            categoryRepo.save(electronics);


            Category phone = new Category("Mobiles");
            phone.setCategory(electronics);
            categoryRepo.save(phone);

            Category fashion = new Category("Fashion");
            categoryRepo.save(fashion);


            Category shoes = new Category("Shoes");
            shoes.setCategory(fashion);
            categoryRepo.save(shoes);

            Category boots = new Category("Boots");
            boots.setCategory(shoes);
            categoryRepo.save(boots);


            Category shirts = new Category("Shirts");
            shirts.setCategory(fashion);
            categoryRepo.save(shirts);

            Category jeans = new Category("Jeans");
            jeans.setCategory(fashion);
            categoryRepo.save(jeans);

            Category toys = new Category("Toys");
            categoryRepo.save(toys);

            Category footwear = new Category("Footwear");
            categoryRepo.save(footwear);

            Category accessories = new Category("Accessories");
            categoryRepo.save(accessories);

            Category grocery = new Category("Grocery");
            categoryRepo.save(grocery);

            Category watches = new Category("Watches");
            categoryRepo.save(watches);

            Category books = new Category("Books");
            categoryRepo.save(books);

            Set<Product_variation> productVariationSet =new HashSet<>();

            Product_variation variation = new Product_variation();
            variation.setPrice(100000.0f);
            variation.setQuantityAvailable(5);
            productVariationRepo.save(variation);

            productVariationSet.add(variation);

            Product product = new Product("iphone 11", "Double camera System", "Apple", false, false);
            product.setSeller(seller1.getSeller());
            product.setCategory(phone);
            product.setIs_active(true);
            product.setProductVariations(productVariationSet);
            productRepo.save(product);

            productVariationSet.clear();

            //apple variation->iphone11 pro
            Product_variation productVariation= new Product_variation();
            productVariation.setPrice(10000.0f);
            productVariation.setQuantityAvailable(10);
            productVariationRepo.save(productVariation);


            Product_variation productVariation2 = new Product_variation();
            productVariation2.setPrice(112200.0f);
            productVariation2.setQuantityAvailable(21);
            productVariationRepo.save(productVariation2);


            productVariationSet.add(productVariation);
            productVariationSet.add(productVariation2);

            Product product1 = new Product("iphone 11 pro", "6.1-inch Liquid Retina HD LCD display", "Apple", false, false);
            product1.setSeller(seller1.getSeller());
            product1.setCategory(phone);
            product1.setIs_active(true);
            product1.setProductVariations(productVariationSet);
            productRepo.save(product1);


            Product product2 = new Product("Formal Shirt", "Printed Slim Fit Formal Shirt", "UCB", false, false);
            product2.setSeller(seller2.getSeller());
            product2.setCategory(shirts);
            product2.setIs_active(true);
            productRepo.save(product2);

            Product product3 = new Product("Casual Shirt", "Regular Fit Casual Shirt", "LP", false, false);
            product3.setSeller(seller2.getSeller());
            product3.setCategory(shirts);
            product3.setIs_active(true);
            productRepo.save(product3);





        }
  }

    }

