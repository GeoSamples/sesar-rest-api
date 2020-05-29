package org.earthchem.sesarrestapi.dao;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

public class CountryDAO implements Serializable {
			private static final long serialVersionUID = 1L;

			@Id
			@Column(name="country_id")
			private Integer countryId;

			@Column(name="is_active")
			private Integer isActive;

			private String name;


			public CountryDAO() {
			}

			public Integer getCountryId() {
				return this.countryId;
			}

			public void setCountryId(Integer countryId) {
				this.countryId = countryId;
			}

			public Integer getIsActive() {
				return this.isActive;
			}

			public void setIsActive(Integer isActive) {
				this.isActive = isActive;
			}

			public String getName() {
				return this.name;
			}

			public void setName(String name) {
				this.name = name;
			}

}
