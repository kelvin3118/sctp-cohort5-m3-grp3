package sg.edu.ntu.m3p3.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;

    @NotEmpty
    @Column(name = "user_name")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{5,20}$", message = "Username must be 5-20 characters long and contain only alphanumeric characters, underscore, or hyphen")
    private String userName;

    @NotEmpty
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and be at least 8 characters long")
    private String password;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "login_attempt_counter")
    private int loginAttemptCounter;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public User() {
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    

}
