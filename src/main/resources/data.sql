insert into static_template (`id`, `template_name`, `image_data`) VALUES
(1, 'image 1', (SELECT FILE_READ('classpath:static/A4 - 1.png'))),
(2, 'image 2', (SELECT FILE_READ('classpath:static/A4 - 1.png'))),
(3, 'image 3', (SELECT FILE_READ('classpath:static/A4 - 1.png'))),
(4, 'image 4', (SELECT FILE_READ('classpath:static/A4 - 1.png'))),
(5, 'image 5', (SELECT FILE_READ('classpath:static/A4 - 1.png'))),
(6, 'image 6', (SELECT FILE_READ('classpath:static/A4 - 1.png'))),
(7, 'image 7', (SELECT FILE_READ('classpath:static/A4 - 1.png')));


--CREATE TABLE resume_data AS
--SELECT obj.id, obj.objectives from objective obj
--JOIN contact_of_user contact ON obj.id = contact.id;