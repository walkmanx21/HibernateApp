package org.example.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ITEM", schema = "HIBERNATE_REPOSITORY")
public class Item {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    private Person owner;

    @Column(name = "ITEM_NAME")
    private String itemName;

    public Item(Person owner, String itemName) {
        this.owner = owner;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
               "id=" + id +
               ", itemName='" + itemName + '\'' +
               '}';
    }
}
