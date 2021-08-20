# Spring YAML


### GET /persons

You just need to add the content-type that you want to receive

application/json to receive JSON

text/yaml or text/yml to receive YAML 

By default will returns JSON

```
curl --request GET \
  --url http://localhost:8088/persons \
  --header 'Accept: '
```
### POST /persons

Accept: text/yaml
Content-Type: application/json

```
curl --request POST \
  --url http://localhost:8088/persons \
  --header 'Accept: text/yaml' \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Matheus",
	"age": 26
}'
```

Returns text/yaml

---

Content-Type: application/json
Accept: application/json

```
curl --request POST \
  --url http://localhost:8088/persons \
  --header 'Accept: application/json' \
  --header 'Content-Type: application/json' \
  --data '{
  "name": "Matheus",
  "age": 26
}'
```

Returns application/json

---

Accept: application/json
Content-Type: text/yaml

```
curl --request POST \
  --url http://localhost:8088/persons \
  --header 'Accept: application/json' \
  --header 'Content-Type: text/yaml' \
  --data 'name: Matheus Cruz
age: 26'
```

Returns application/json

--- 

Accept: text/yaml 
Content-Type: text/yaml

```
curl --request POST \
  --url http://localhost:8088/persons \
  --header 'Accept: text/yaml' \
  --header 'Content-Type: text/yaml' \
  --data 'name: Matheus Cruz
age: 26'
```

Returns text/yaml

---

- When Content-Type is application/json and the body is text/yaml 
I receive 400 Bad request

- When Content-Type is text/yaml and the body is a application/json
I receive 200 OK

- When Content-Type is undefined returns 415 Unsupported Media Type
