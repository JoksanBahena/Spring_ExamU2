package com.example.ExamU2_JBP.controllers.client.dtos;

import com.example.ExamU2_JBP.models.client.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClientDto {
    private Long Id;

    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(min = 10, max = 100, message = "El nombre no debe pasar los 100 caracteres")
    private String name;

    @NotEmpty(message = "El apellido no puede estar vacio")
    @Size(min = 10, max = 100, message = "el apellido no debe pasar los 100 caracteres")
    private String lastname;

    @NotEmpty(message = "La direccion no puede estar vacia")
    @Size(min = 10, max = 255, message = "La direccion no debe pasar los 255 caracteres")
    private String direction;

    @NotEmpty(message = "La fecha de nacimiento no puede estar vacia")
    @Size(max = 25, message = "La fecha de nacimiento no puede pasar los 25 caracteres")
    private String birthday;

    @NotEmpty(message = "El numero de telefono no puede estar vacio")
    @Size(max = 10, message = "El numero de telefono no debe pasar los 10 digitos")
    @Pattern(regexp = "^[0-9]{10}$", message = "El número de teléfono debe contener sólo 10 dígitos")
    private String phone_number;

    @NotEmpty(message = "El email no puede estar vacio")
    @Email(message = "El email no es valido")
    private String email;

    @NotEmpty(message = "La categoria no puede estar vacia")
    @Size(min = 5, max = 30, message = "La categoria no debe pasar los 30 caracteres")
    private String category;

    public Client castToClient() {
        return new Client(getId(), getName(), getLastname(), getDirection(), getBirthday(), getPhone_number(), getEmail(), getCategory(), null);
    }
}
