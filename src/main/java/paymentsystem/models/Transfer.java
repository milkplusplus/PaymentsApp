package paymentsystem.models;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transfer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    private Date tr_date;
	private Integer tr_sum;
	private Integer tr_type;
	private Integer card_id;
	private Integer client_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTr_date() {
		return tr_date;
	}
	public void setTr_date(Date tr_date) {
		this.tr_date = tr_date;
	}
	public Integer getTr_sum() {
		return tr_sum;
	}
	public void setTr_sum(Integer tr_sum) {
		this.tr_sum = tr_sum;
	}
	public Integer getTr_type() {
		return tr_type;
	}
	public void setTr_type(Integer tr_type) {
		this.tr_type = tr_type;
	}
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	
}
