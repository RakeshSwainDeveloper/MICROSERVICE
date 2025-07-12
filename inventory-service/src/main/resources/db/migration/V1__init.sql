create table t_inventory(
	id bigint(20) not null auto_increment,
    sku_code varchar(255),
    quantityt_order int(11),
    primary key(id)
)