package productshop.domain.dtos.seed.xml;

import productshop.domain.dtos.seed.CategorySeedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesCategoryDto {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categorySeedDtos;

    public CategoriesCategoryDto() {
    }

    public List<CategorySeedDto> getCategorySeedDtos() {
        return this.categorySeedDtos;
    }

    public void setCategorySeedDtos(List<CategorySeedDto> categorySeedDtos) {
        this.categorySeedDtos = categorySeedDtos;
    }
}
