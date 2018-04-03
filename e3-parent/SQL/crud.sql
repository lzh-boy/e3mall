SELECT * FROM tb_content;			-- 内容表
SELECT * FROM tb_content_category;		-- 内容分类表
SELECT * FROM tb_item ORDER BY created DESC;				-- 商品表
SELECT * FROM tb_item_desc;			-- 商品详情
SELECT * FROM tb_item_cat;			-- 商品分类

SELECT * FROM tb_item_cat tic ORDER BY tic.sort_order

-- EasyUI tree
-- 树控件数据格式化
-- 每个节点都具备以下属性：
-- 
-- id：节点ID，对加载远程数据很重要。
-- text：显示节点文本。
-- state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
-- checked：表示该节点是否被选中。
-- attributes: 被添加到节点的自定义属性。
-- children: 一个节点数组声明了若干节点。
-- 商品类目
SELECT tic.id, tic.name `text`, IF(tic.is_parent = 1, 'closed', 'open') state
FROM tb_item_cat tic
WHERE tic.parent_id = 0;

-- 内容分类
SELECT tca.id, tca.name `text`, IF(tca.is_parent = 1, 'closed', 'open') state
FROM tb_content_category tca
WHERE tca.parent_id = 30;

SELECT tca.*
FROM tb_content_category tca
WHERE tca.parent_id = 0 AND tca.status = 1;

UPDATE tb_content_category SET `name` = '宜立方商城' WHERE id = 30;

SELECT tca.id, tca.name `text`, IF(tca.is_parent = 1, 'closed', 'open') state FROM tb_content_category tca WHERE tca.parent_id = 0;

-- 获取主键
SELECT LAST_INSERT_ID();

SELECT * FROM tb_content tc
WHERE tc.category_id = 89;

-- 查询商品
SELECT ti.id, ti.title, ti.sell_point, ti.price, ti.image, tbc.name category_name
FROM tb_item ti
LEFT JOIN tb_item_cat tbc ON tbc.id = ti.cid
WHERE ti.status = 1;

SHOW COLUMNS FROM tb_item;
SHOW COLUMNS FROM tb_item_cat;

SELECT * FROM mysql.user;