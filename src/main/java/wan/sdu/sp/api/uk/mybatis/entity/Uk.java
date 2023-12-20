package wan.sdu.sp.api.uk.mybatis.entity;


import lombok.Data;

@Data
public class Uk {
    private String name;
    private Integer id;

    public Uk(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    public Uk(String name) {
        this.name = name;
    }

    public Uk() {
    }
}
