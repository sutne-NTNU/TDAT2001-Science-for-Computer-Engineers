function [felt, styrke] = MagnetfeltFraLadningIBevegelseVektor(q, v_vektor, r_vektor)
felt = cross(v_vektor, r_vektor);
r = 0;
vxr = 0;
for i = 1:size(v_vektor')
	r = r + r_vektor(1, i)^2; 
	vxr = vxr + felt(1, i)^2;
end
r = sqrt(r);
vxr = sqrt(vxr);
styrke = (u_0/(4*pi))*(q*vxr)/r^3;
end

