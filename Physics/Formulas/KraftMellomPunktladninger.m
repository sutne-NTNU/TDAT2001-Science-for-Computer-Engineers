function res = KraftMellomPunktladninger(F, q1, q2, r)
if F == 0
	res = k * abs(q1*q2)/r^2;
elseif q1 == 0
	res = (F*r^2)/(k*abs(q2));
elseif q2 == 0
	res = (F*r^2)/(k*abs(q1));
elseif r == 0
	res = sqrt(k * abs(q1*q2)/F);
end
end

