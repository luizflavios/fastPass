package br.com.newtonpaiva.fastpass.model;

import br.com.newtonpaiva.fastpass.generic.GenericEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment_methods")
public class PaymentMethod implements Serializable, GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Boolean active;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "debit_card_id")
    private DebitCard debitCard;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
