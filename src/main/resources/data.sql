INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 1, '366-ФЗ', 'Федеральный закон', 'Об обеспечении доступа к информации о деятельности государственных органов и органов местного самоуправления', '2017-12-28', 'https://minobrnauki.gov.ru/upload/iblock/4be/4bebe0604c0b6fc5312c2d20f5d7f633.pdf') ON CONFLICT (id) DO NOTHING;
INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 2, '59-ФЗ', 'Федеральный закон', 'О порядке рассмотрения обращений граждан Российской Федерации', '2018-12-27', 'https://minobrnauki.gov.ru/upload/iblock/074/0748aa9fa338918641fc3c2eefd8da62.pdf') ON CONFLICT (id) DO NOTHING;
INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 3, '392-ФЗ', 'Федеральный закон', 'О внесении изменений в отдельные законодательные акты Российской Федерации по вопросам совершенствования проведения независимой оценки качества условий оказания услуг организациями в сфере культуры, охраны здоровья, образования, социального обслуживания и федеральными учреждениями медико-социальной экспертизы', '2017-12-5', 'https://minobrnauki.gov.ru/upload/iblock/f5d/f5d1b7c5e7cf09a724be51f14ca7008b.pdf') ON CONFLICT (id) DO NOTHING;
INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 4, '76', 'Указ Президента', 'О мерах по реализации государственной научно-технической политики в области экологического развития Российской Федерации и климатических изменений', '2021-02-08', 'https://minobrnauki.gov.ru/upload/iblock/0c4/0c45e62075f5081661554a4956e7b518.pdf') ON CONFLICT (id) DO NOTHING;
INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 5, '206', 'Указ Президента', 'Об объявлении в Российской Федерации нерабочих дней', '2020-03-25', 'https://minobrnauki.gov.ru/upload/iblock/43f/43fcb0b093a46ea0b2fac1d9eac94730.pdf') ON CONFLICT (id) DO NOTHING;
INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 6, 'МН-3/1459-ДП', 'Письмо', 'О внесении изменений в перечень отраслей науки', '2023-07-06', 'https://minobrnauki.gov.ru/upload/iblock/0a7/rb63p5f0pzvc5ptdrjf2f1ledsdrklbh.pdf') ON CONFLICT (id) DO NOTHING;
INSERT INTO documents (created_by, created_at, id, number, type, name, date, url) VALUES ('admin', NOW(), 7, 'МН-17/521', 'Письмо', '', '2021-03-15', 'https://minobrnauki.gov.ru/upload/iblock/5b1/5b1a71bf82ba8833b6f7259b8b4ebf40.pdf') ON CONFLICT (id) DO NOTHING;