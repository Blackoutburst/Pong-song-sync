uniform vec2 lightLocation;
uniform vec3 lightColor;

void main() {
	float distance = length(lightLocation.y - gl_FragCoord.y);
	float attenuation = 1.0/distance;
	vec3 color = vec3(attenuation, attenuation, attenuation) * vec3(lightColor);

	gl_FragColor = vec4(color,0);
}
