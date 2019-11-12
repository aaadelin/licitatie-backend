package com.ubb59.proiectcolectiv.Licitatie.Server.Licitatie.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date dateAdded;
    private Boolean closed;
    @ColumnDefault(value="0.0")
    private Double startingPrice;
    private Boolean isPrivate;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    private List<Bid> bids;
    @OneToOne
    private Bid winningBid;
    @ManyToOne
    private User owner;
    @ManyToOne
    private Category category;
}
