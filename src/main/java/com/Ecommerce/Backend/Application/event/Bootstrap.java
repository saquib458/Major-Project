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
    categoryRepo categoryRepo;

    @Autowired
    productRepo productRepo;

    @Autowired
    product_variationRepo productVariationRepo;


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


            category electronics = new category("Electronics");
            electronics.setCategory(null);
            categoryRepo.save(electronics);


            category phone = new category("Mobiles");
            phone.setCategory(electronics);
            categoryRepo.save(phone);

            category fashion = new category("Fashion");
            categoryRepo.save(fashion);


            category shoes = new category("Shoes");
            shoes.setCategory(fashion);
            categoryRepo.save(shoes);

            category boots = new category("Boots");
            boots.setCategory(shoes);
            categoryRepo.save(boots);


            category shirts = new category("Shirts");
            shirts.setCategory(fashion);
            categoryRepo.save(shirts);

            category jeans = new category("Jeans");
            jeans.setCategory(fashion);
            categoryRepo.save(jeans);

            category toys = new category("Toys");
            categoryRepo.save(toys);

            category footwear = new category("Footwear");
            categoryRepo.save(footwear);

            category accessories = new category("Accessories");
            categoryRepo.save(accessories);

            category grocery = new category("Grocery");
            categoryRepo.save(grocery);

            category watches = new category("Watches");
            categoryRepo.save(watches);

            category books = new category("Books");
            categoryRepo.save(books);

            Set<product_variation> productVariationSet =new HashSet<>();

            product_variation variation = new product_variation();
            variation.setPrice(100000.0f);
            variation.setQuantityAvailable(5);
            productVariationRepo.save(variation);

            productVariationSet.add(variation);

            product product = new product("iphone 11", "Double camera System", "Apple", false, false);
            product.setSeller(seller1.getSeller());
            product.setCategory(phone);
            product.setIs_active(true);
            product.setProductVariations(productVariationSet);
            productRepo.save(product);

            productVariationSet.clear();

            //apple variation->iphone11 pro
            product_variation productVariation= new product_variation();
            productVariation.setPrice(10000.0f);
            productVariation.setQuantityAvailable(10);
            productVariationRepo.save(productVariation);


            product_variation  productVariation2 = new product_variation ();
            productVariation2.setPrice(112200.0f);
            productVariation2.setQuantityAvailable(21);
            productVariationRepo.save(productVariation2);


            productVariationSet.add(productVariation);
            productVariationSet.add(productVariation2);

            product product1 = new product("iphone 11 pro", "6.1-inch Liquid Retina HD LCD display", "Apple", false, false);
            product1.setSeller(seller1.getSeller());
            product1.setCategory(phone);
            product1.setIs_active(true);
            product1.setProductVariations(productVariationSet);
            productRepo.save(product1);


            product product2 = new product("Formal Shirt", "Printed Slim Fit Formal Shirt", "UCB", false, false);
            product2.setSeller(seller2.getSeller());
            product2.setCategory(shirts);
            product2.setIs_active(true);
            productRepo.save(product2);

            product product3 = new product("Casual Shirt", "Regular Fit Casual Shirt", "LP", false, false);
            product3.setSeller(seller2.getSeller());
            product3.setCategory(shirts);
            product3.setIs_active(true);
            productRepo.save(product3);





        }
  }

    }

