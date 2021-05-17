package kr.legossol.api.workFile.dmain;

import javax.persistence.*;

import kr.legossol.api.art.domain.Art;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "work_files")
@NoArgsConstructor
@Data
public class WorkFile {
    @Id
    @GeneratedValue
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "ofile_name")
    private String ofileName;
    @Column(name = "rep_img")
    private String repImg;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art;

}