package com.aamir.rating.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "RATING_MICRO")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RATING_ID")
    @SequenceGenerator(name = "SEQ_RATING_ID", sequenceName = "SEQ_RATING_ID", allocationSize = 1)
    @Column(name = "RATING_ID", unique = true, nullable = false)
    private Long ratingId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "HOTEL_ID")
    private Long hotelId;
    @Column(name = "RATING")
    private Integer rating;
    @Column(name = "FEEDBACK")
    private String feedBack;
}
