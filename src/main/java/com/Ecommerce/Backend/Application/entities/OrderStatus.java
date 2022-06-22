package com.Ecommerce.Backend.Application.entities;

import com.Ecommerce.Backend.Application.enums.FromStatus;
import com.Ecommerce.Backend.Application.enums.ToStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class OrderStatus {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;


        @JsonIgnore
        @OneToOne
        @MapsId
        private OrderProduct orderProduct;

        @Enumerated(EnumType.STRING)
        private FromStatus fromStatus;

        @Enumerated(EnumType.STRING)
        private ToStatus toStatus;

        private String transitionNotesComments;

        public OrderStatus() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public OrderProduct getOrderProduct() {
                return orderProduct;
        }

        public void setOrderProduct(OrderProduct orderProduct) {
                this.orderProduct = orderProduct;
        }

        public FromStatus getFromStatus() {
                return fromStatus;
        }

        public void setFromStatus(FromStatus fromStatus) {
                this.fromStatus = fromStatus;
        }

        public ToStatus getToStatus() {
                return toStatus;
        }

        public void setToStatus(ToStatus toStatus) {
                this.toStatus = toStatus;
        }

        public String getTransitionNotesComments() {
                return transitionNotesComments;
        }

        public void setTransitionNotesComments(String transitionNotesComments) {
                this.transitionNotesComments = transitionNotesComments;
        }
}


