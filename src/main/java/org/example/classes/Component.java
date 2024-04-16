package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Component {
    private String idComponent;
    private String page;
    private String classComponent;
    private List<String> atributs;

}
