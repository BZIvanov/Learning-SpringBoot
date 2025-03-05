# HAL (Hypertext Application Language)

HAL is a standard format for including links in REST API responses.

- It helps clients **discover** and **navigate** an API dynamically.
- Links are stored under the `_links` section.

## HATEOAS (Hypermedia as the Engine of Application State)

HATEOAS is a REST API principle where responses include links to guide the client to other related resources.

## When to use HAL & HATEOAS?

- If you want **self-discoverable APIs** with built-in navigation.
- If your API **evolves frequently**, so clients can follow links dynamically.
- If you want to **follow REST best practices** and improve API usability.
