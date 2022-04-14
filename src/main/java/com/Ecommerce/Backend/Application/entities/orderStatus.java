package com.Ecommerce.Backend.Application.entities;

import com.Ecommerce.Backend.Application.enums.fromStatus;
import com.Ecommerce.Backend.Application.enums.toStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class orderStatus {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;


        @JsonIgnore
        @OneToOne
        @MapsId
        private orderProduct orderProduct;

        @Enumerated(EnumType.STRING)
        private fromStatus fromStatus;

        @Enumerated(EnumType.STRING)
        private toStatus toStatus;

        private String transitionNotesComments;

        public orderStatus() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public com.Ecommerce.Backend.Application.entities.orderProduct getOrderProduct() {
                return orderProduct;
        }

        public void setOrderProduct(com.Ecommerce.Backend.Application.entities.orderProduct orderProduct) {
                this.orderProduct = orderProduct;
        }

        public com.Ecommerce.Backend.Application.enums.fromStatus getFromStatus() {
                return fromStatus;
        }

        public void setFromStatus(com.Ecommerce.Backend.Application.enums.fromStatus fromStatus) {
                this.fromStatus = fromStatus;
        }

        public com.Ecommerce.Backend.Application.enums.toStatus getToStatus() {
                return toStatus;
        }

        public void setToStatus(com.Ecommerce.Backend.Application.enums.toStatus toStatus) {
                this.toStatus = toStatus;
        }

        public String getTransitionNotesComments() {
                return transitionNotesComments;
        }

        public void setTransitionNotesComments(String transitionNotesComments) {
                this.transitionNotesComments = transitionNotesComments;
        }
}


