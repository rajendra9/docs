package com.htc.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.htc.data.domain.PersonDto; 


@Configuration
@EnableCassandraRepositories
public class SprCassConfig extends AbstractCassandraConfiguration 
    implements PersonDao{	
	
	public static final String KEY_SPACE = "my_hr";
	
	@Autowired
	CassandraTemplate template;
	
    @Override
    public String getKeyspaceName() {
	 return KEY_SPACE;
    }

	@Override
	public long count() {
		return this.template.count(PersonDto.class);
	}

	@Override
	public void delete(PersonDto person) {
		this.template.delete(person);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends PersonDto> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
       this.template.deleteById(id, com.htc.data.domain.PersonDto.class);
	}		
		
	@Override
	public boolean existsById(Integer id) {
		PersonDto ret = this.searchPerson(id);
		return (ret.getPersonName()!=null ? true : false);
	}

	@Override
	public Iterable<PersonDto> findAllById(Iterable<Integer> arg0) {
		String cqlAll = "select *  from sprdata_persons";
		List<PersonDto> ret = this.template.select( cqlAll, com.htc.data.domain.PersonDto.class);
        return ret;
	}

	@Override
	public Optional<PersonDto> findById(Integer id) {
	  Optional<PersonDto> ret = Optional.empty();
	  try{	
	    String cqlOne = "select *  from sprdata_persons where personid=" + id;
		PersonDto searched = this.template.selectOne(cqlOne,  com.htc.data.domain.PersonDto.class);
	    ret = Optional.of(searched);
	   }catch(Exception ex) {
		 ex.printStackTrace();  
	   }
	  return ret;
	}
	
	@Override
	public <S extends PersonDto> S save(S person) {
		this.template.insert(person);
		return person;
	}

	@Override
	public <S extends PersonDto> Iterable<S> saveAll(Iterable<S> list) {
		this.template.insert(list);
		return list;
		
	}

	@Override
	public PersonDto searchPerson(int id) {
		String cqlOne = "select *  from sprdata_persons where personid=" + id;
		PersonDto ret = this.template.selectOne(cqlOne,  com.htc.data.domain.PersonDto.class);
	    return ret;
	}

	@Override
	public List<PersonDto> findAll() {
		String cqlAll = "select *  from sprdata_persons";
		List<PersonDto> ret = this.template.select( cqlAll, com.htc.data.domain.PersonDto.class);
        return ret;  
	}

	
	
}
